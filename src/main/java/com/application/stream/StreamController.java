
package com.application.model.stream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/streams")
public class StreamController {

    @Autowired
    private StreamRepository streamRepository;

    @GetMapping
    public List<Stream> getAllStreams() {
        return streamRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stream createStream(@RequestBody Stream stream) {
        return streamRepository.save(stream);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stream> getStreamById(@PathVariable Long id) {
        return streamRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stream> updateStream(
            @PathVariable Long id,
            @RequestBody Stream updatedStream) {

        return streamRepository.findById(id)
                .map(existingStream -> {
                    existingStream.setStreamName(updatedStream.getStreamName());
                    return ResponseEntity.ok(streamRepository.save(existingStream));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStream(@PathVariable Long id) {
        if (!streamRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        streamRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
