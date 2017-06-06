package com.sarlmoclen.two;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sarlmoclen.common.MainActionName;
import com.sarlmoclen.router.SRouter;
import com.sarlmoclen.router.SRouterRequest;
import com.sarlmoclen.router.SRouterResponse;

public class ChildActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_activity_child);
        if(getIntent().getStringExtra("from")!=null){
            setTitle("two("+getIntent().getStringExtra("from")+")");
        }else{
            setTitle("two");
        }

        findViewById(R.id.go).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.go){
            SRouterResponse mSRouterResponse = SRouter.getInstance().sendMessage(
                    ChildActivity.this, SRouterRequest.creat()
                            .action(MainActionName.name)
                            .data("from","from two"));
            Toast.makeText(ChildActivity.this
                    ,mSRouterResponse.getResult().toString()
                    ,Toast.LENGTH_SHORT).show();
        }
    }

}
