package com.ironyard.data;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;

/**
 * Created by osmanidris on 1/26/17.
 */

public class AgentTest {
    @Test
    public void loadPattern() throws Exception {
        ArrayList<Agent> agentList = Agent.loadPattern();
        assertNotNull("Array List of Agent should not equal to null", agentList);
        assertEquals("Array list size should be equal to 11", 11,agentList.size());
    }

}