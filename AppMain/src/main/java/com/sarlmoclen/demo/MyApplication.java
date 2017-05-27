package com.sarlmoclen.demo;

import com.sarlmoclen.common.MainActionName;
import com.sarlmoclen.common.OneActionName;
import com.sarlmoclen.common.TwoActionName;
import com.sarlmoclen.router.SApplication;
import com.sarlmoclen.router.SRouter;
import com.sarlmoclen.one.OneAction;
import com.sarlmoclen.two.TwoAction;

/**
 * Created by sarlmoclen on 2017/5/24.
 */

public class MyApplication extends SApplication{

    @Override
    public void registerAction() {
        SRouter.getInstance().registerAction(OneActionName.name, new OneAction());
        SRouter.getInstance().registerAction(TwoActionName.name, new TwoAction());
        SRouter.getInstance().registerAction(MainActionName.name, new MainAction());
    }

}
