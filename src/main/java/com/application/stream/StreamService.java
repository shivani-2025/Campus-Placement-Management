
package com.application.model.stream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

    @Autowired
    private StreamRepository streamRepository;

    public List<Stream> getAllStreams() {
        return streamRepository.findAll();
    }

    public Stream createStream(Stream stream) {
        return streamRepository.save(stream);
    }

    public Stream getStreamById(Integer id) {
        return streamRepository.findById(id).orElse(null);
    }
}