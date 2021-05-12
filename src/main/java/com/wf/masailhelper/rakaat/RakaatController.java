package com.wf.masailhelper.rakaat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin
@RestController
public class RakaatController {
    Action action;
    Salaat salaat;
    List<Integer> options = new ArrayList<>();

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

    @PostMapping("/option")
    public void options(@RequestBody String optionString) {
        Integer option = Integer.valueOf(optionString);
        if (this.options.size() == 2) {
            throw new UnsupportedOperationException("You already have two options! Please deselect one first " + options);
        }
        if (this.options.contains(option)) {
            this.options.remove((Integer) option);
        } else {
            this.options.add(option);
        }
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
