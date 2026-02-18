package com.application.project.Round;

import com.application.project.DetailedRound.DetailedRound;
import com.application.project.DetailedRound.DetailedRoundRepository;
import com.application.project.Employee.Employee;
import com.application.project.Employee.EmployeeRepository;
import com.application.project.context.EmployeeContext;
import com.application.project.model.CreateRoundRequest;
import com.application.project.model.RoundView;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecruiterRoundService {

    private final DetailedRoundRepository detailedRoundRepository;
    private final EmployeeRepository employeeRepository;

    public RecruiterRoundService(
            DetailedRoundRepository detailedRoundRepository,
            EmployeeRepository employeeRepository) {

        this.detailedRoundRepository = detailedRoundRepository;
        this.employeeRepository = employeeRepository;
    }

    //to get all rounds
    public List<RoundView> getAllRounds() {

        Employee recruiter = validateRecruiter();

        return detailedRoundRepository.findAll()
                .stream()
                .map(this::toView)
                .toList();
    }

    //Creating a round
    public RoundView createRound(CreateRoundRequest request) {

        Employee recruiter = validateRecruiter();

        // round name cannot be blank
        if (request == null ||
            request.getRoundName() == null ||
            request.getRoundName().trim().isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Round name cannot be empty"
            );
        }

        // prevent duplicate round names
        boolean exists = detailedRoundRepository.findAll()
                .stream()
                .anyMatch(r ->
                        r.getRoundName()
                                .equalsIgnoreCase(request.getRoundName().trim()));

        if (exists) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Round already exists"
            );
        }

        DetailedRound round = new DetailedRound();
        round.setRoundName(request.getRoundName().trim());

        detailedRoundRepository.save(round);

        return toView(round);
    }
    //to delete a round
    public void deleteRound(Integer roundId) {

        Employee recruiter = validateRecruiter();

        DetailedRound round = detailedRoundRepository.findById(roundId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Round not found"
                ));

        // If later rounds are linked to drives,this is where you check & block deletion
        detailedRoundRepository.delete(round);
    }

    //checking whether he is recruiter/not
    private Employee validateRecruiter() {

        Integer employeeId = EmployeeContext.get();
        if (employeeId == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Employee not logged in"
            );
        }

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Employee not found"
                ));

        if (!"recruiter".equalsIgnoreCase(
                employee.getEmployeeStatus().getDesignation())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Only recruiter allowed"
            );
        }

        return employee;
    }

    //converts a JPA entity into a DTO used for API responses
    private RoundView toView(DetailedRound round) {
        RoundView view = new RoundView();
        view.setRoundName(round.getRoundName());
        return view;
    }
}
