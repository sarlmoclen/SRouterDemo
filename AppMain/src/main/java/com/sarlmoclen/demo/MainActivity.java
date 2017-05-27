package com.sarlmoclen.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sarlmoclen.common.OneActionName;
import com.sarlmoclen.router.SRouter;
import com.sarlmoclen.router.SRouterRequest;
import com.sarlmoclen.router.SRouterResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        if(getIntent().getStringExtra("from")!=null){
            setTitle("main("+getIntent().getStringExtra("from")+")");
        }else{
            setTitle("main");
        }

        findViewById(R.id.go).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.go){
            SRouterResponse mSRouterResponse = SRouter.getInstance().sendMessage(
                    MainActivity.this,SRouterRequest.creat()
                    .action(OneActionName.name)
                    .data("from","from main"));
            Toast.makeText(MainActivity.this
                    ,mSRouterResponse.getResult().toString()
                    ,Toast.LENGTH_SHORT).show();
        }
    }
}
