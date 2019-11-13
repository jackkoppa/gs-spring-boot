package candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.Collection;
import java.util.ArrayList;

@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;
    
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "Hey it me!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/candidates")
    public Collection<Candidate> getAllCandidates() {
        Collection<Candidate> candidateCollection = new ArrayList<Candidate>();
        Iterable<Candidate> candidates = candidateRepository.findAll();
        candidates.forEach(candidateCollection::add);
        return candidateCollection;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/candidate")
    public Candidate addCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/candidates/{lastName}")
    public Collection<Candidate> searchForCandidatesByLastName(@PathVariable String lastName) {
        Collection<Candidate> candidateCollection = new ArrayList<Candidate>();
        Iterable<Candidate> candidates = candidateRepository.findByLastName(lastName);
        candidates.forEach(candidateCollection::add);
        return candidateCollection;
    }
    
}