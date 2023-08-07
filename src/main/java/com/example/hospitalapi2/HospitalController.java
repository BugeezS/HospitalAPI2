package com.example.hospitalapi2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController {
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;

    public HospitalController(DoctorRepository doctorRepository, VisitRepository visitRepository) {
        this.doctorRepository = doctorRepository;
        this.visitRepository = visitRepository;
    }

    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PostMapping("/visits")
    public Visit createVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/visits")
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    // Add other CRUD endpoints and custom query endpoints here
}