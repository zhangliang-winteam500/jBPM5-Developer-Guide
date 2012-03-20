/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.jbpm5.dev.guide;

import com.salaboy.jbpm5.dev.guide.executor.CommandContext;
import com.salaboy.jbpm5.dev.guide.executor.CommandDoneHandler;
import com.salaboy.jbpm5.dev.guide.executor.ExecutionResults;

/**
 *
 * @author salaboy
 */
public class SimpleIncrementCommandDoneHandler implements CommandDoneHandler{

    public void onCommandDone(CommandContext ctx, ExecutionResults results) {
        String businessKey = (String)ctx.getData("businessKey");
        System.out.println(" ??? Business key: "+businessKey);
        Long increment = (Long)ExecutorSimpleTest.cachedEntities.get(businessKey);
        System.out.println(" >>> Before Incrementing = "+increment);
        ExecutorSimpleTest.cachedEntities.put(businessKey, increment + 1);
        System.out.println(" >>> After Incrementing = "+ExecutorSimpleTest.cachedEntities.get(businessKey));
        System.out.println(" ??? Command Done!");
        System.out.println(" ??? Command Full Context = "+ctx);
        System.out.println(" ??? Command Full Results = "+results);
    }
    
}