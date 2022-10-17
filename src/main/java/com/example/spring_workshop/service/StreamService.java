package com.example.spring_workshop.service;

import com.example.spring_workshop.entites.Stream;
import com.example.spring_workshop.entites.dto.StreamDTO;
import com.example.spring_workshop.repository.StreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import static com.example.spring_workshop.entites.dto.StreamDTO.toStreamDto;
import static com.example.spring_workshop.entites.dto.StreamDTO.toStreamEntity;

@Service
@RequiredArgsConstructor
public class StreamService {
    private final StreamRepository streamRepository;

    @Transactional
    public StreamDTO createStream(StreamDTO streamDTO){
        Stream stream = streamRepository.save(toStreamEntity(streamDTO));

        return toStreamDto(stream);
    }

    @Transactional
    public List<StreamDTO> getAllStreams() {
        return streamRepository.findAll().stream()
                .map(StreamDTO::toStreamDto)
                .collect(Collectors.toList());
    }

    public List<String> getStreamNamesByDepartment(String department) {
        return streamRepository.getAllByDepartment(department).stream()
                .map(Stream::getName)
                .collect(Collectors.toList());
    }

    public Stream getStreamByName(String streamName){
        return streamRepository.getStreamByName(streamName);
    }

    public Stream getStreamById(String streamId){
        return streamRepository.getStreamById(Long.valueOf(streamId));
    }
}
