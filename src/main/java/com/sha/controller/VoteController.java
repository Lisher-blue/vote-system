package com.sha.controller;

import com.sha.entity.Options;
import com.sha.entity.User;
import com.sha.entity.Vote;
import com.sha.exception.UserException;
import com.sha.exception.msg.UserMessage;
import com.sha.mapper.OptionsMapper;
import com.sha.mapper.UserMapper;
import com.sha.mapper.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author Lisher
 */
@Controller
@RequestMapping("vote")
public class VoteController {
    @Autowired
    private VoteMapper voteMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OptionsMapper optionsMapper;

    @PostMapping("{id}")
    public String vote(@PathVariable("id") int id, int[] optionIds, Model model) {

        User user = userMapper.selectByUserId(id);
        if (user == null) {
            throw new UserException(UserMessage.USER_IS_NULL);
        }
        for (int oid : optionIds) {
            Vote vote = voteMapper.selectByPid(oid);
            if (vote == null) {
                vote = new Vote();
                vote.setPId(oid);
                vote.setPoll(1);
                voteMapper.insertVote(vote);
            } else {
                Integer poll = vote.getPoll();
                vote.setPoll(poll+1);
                voteMapper.updateVote(vote);
            }
        }
        List<Options> allOptions = optionsMapper.findAllOptions();
        TreeMap<Options,Integer> map = new TreeMap<>(Comparator.comparingInt(Options::getId));
        for (Options option : allOptions) {
            int poll = voteMapper.selectByPid(option.getId()).getPoll();
            map.put(option,poll);
        }
        model.addAttribute("options",map);
        return "show";
    }
}
