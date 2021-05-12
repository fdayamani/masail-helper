package com.wf.masailhelper.rakaat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin
@RestController
public class RakaatController {
    int rakaat;
    Action action;
    List<Integer> options = new ArrayList<>();

    @GetMapping("/actionOptions")
    public List<String> actionOptions() {
        return Arrays.stream(Action.values()).map(Action::getDescription).collect(toList());
    }

    @PostMapping(path = "/rakaat")
    public void rakaat(@RequestBody String rakaatString) {
        this.rakaat = Integer.parseInt(rakaatString);
    }

    @PostMapping("/option")
    public void options(@RequestBody String optionString) {
        Integer option = Integer.valueOf(optionString);
        if (this.options.contains(option)) {
            this.options.remove(option);
        } else if (this.options.size() < 3) {
                this.options.add(option);
        } else {
            throw new UnsupportedOperationException("You already have three options! Please deselect one first " + options);
        }
    }

    @PostMapping("/action")
    public void action(@RequestBody String actionString) {
        this.action = Action.from(actionString);
    }

    @GetMapping("/remedy")
    public Remedy remedy() {
        Doubt doubt = new Doubt(rakaat, options, action);
        System.out.println(doubt);
        Remedy calculate = RemedialCalculator.calculate(doubt);
        System.out.println(calculate);
        return calculate;
    }
}
