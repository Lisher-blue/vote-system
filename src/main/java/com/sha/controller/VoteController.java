package com.sha.controller;

import com.sha.entity.*;
import com.sha.exception.UserException;
import com.sha.exception.msg.UserMessage;
import com.sha.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lisher
 */
@Controller
@RequestMapping("vote")
public class VoteController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OptionsFullMapper optionsFullMapper;
    @Autowired
    private OptionsOriginMapper optionsOriginMapper;

    @PostMapping("{id}")
    public String vote(@PathVariable("id") int id, int[] optionIdsFull, int[] optionIdsOrigin, Model model) {

        User user = userMapper.selectByUserId(id);
        if (user == null) {
            throw new UserException(UserMessage.USER_IS_NULL);
        }
        for (int fid : optionIdsFull) {
            OptionsFull optionsFull = optionsFullMapper.selectById(fid);

            if (optionsFull == null) {
                optionsFull = new OptionsFull();
                optionsFull.setPoll(1);
                optionsFullMapper.insertVote(optionsFull);
            } else {
                Integer poll = optionsFull.getPoll();
                optionsFull.setPoll(poll+1);
                optionsFullMapper.updateVote(optionsFull);
            }
        }

        for (int oid : optionIdsOrigin) {
            OptionsOrigin optionsOrigin = optionsOriginMapper.selectById(oid);

            if (optionsOrigin == null) {
                optionsOrigin = new OptionsOrigin();
                optionsOrigin.setPoll(1);
                optionsOriginMapper.insertVote(optionsOrigin);
            } else {
                Integer poll = optionsOrigin.getPoll();
                optionsOrigin.setPoll(poll+1);
                optionsOriginMapper.updateVote(optionsOrigin);
            }
        }
        return "show";
    }
}
