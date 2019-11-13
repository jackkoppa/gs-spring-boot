package candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;
    
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "Hey it me!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/candidates")
    public Iterable<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.POST, path = "/candidate")
    public Candidate addCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/candidates/{lastName}")
    public Iterable<Candidate> searchForCandidatesByLastName(@PathVariable String lastName) {
        return candidateRepository.findByLastName(lastName);
    }
    
}