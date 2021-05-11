package com.wf.masailhelper.rakaat;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin
@RestController
public class RakaatController {
    Action action;
    Salaat salaat;
    List<Integer> options;

    @GetMapping("/salaatOptions")
    public List<Salaat> salaatOptions() {
        return List.of(Salaat.values());
    }

    @GetMapping("/actionOptions")
    public List<String> actionOptions() {
        return Arrays.stream(Action.values()).map(Action::getDescription).collect(toList());
    }

    @PostMapping(path = "/salaat")
    public void salaat(@RequestBody String salaatString) {
        this.salaat = Salaat.valueOf(salaatString);
    }

    @PostMapping("/options")
    public void options(@RequestBody List<Integer> options) {
        this.options = options;
    }

    @PostMapping("/action")
    public void action(@RequestBody String actionString) {
        this.action = Action.from(actionString);
    }

    @GetMapping("/rakaat")
    public List<RemedialAction> remedy() {
        Doubt doubt = new Doubt(salaat, options, action);
        List<RemedialAction> calculate = RemedialCalculator.calculate(doubt);
        return calculate;
    }
}
