package com.demo.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    private Button receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化消息数据
        initMsgs();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        receive = (Button) findViewById(R.id.receive);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);

        send.setOnClickListener(this);
        receive.setOnClickListener(this);
        /*send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    // 当有新消息是，刷新 ListView 中的显示
                    adapter.notifyItemInserted(msgList.size()-1);
                    // 将 ListView 定位到最后的一行
                    msgRecyclerView.scrollToPosition(msgList.size());
                    // 清空输入框中的内容
                    inputText.setText("");
                }
            }
        });*/
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?.", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    // 当有新消息是，刷新 ListView 中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    // 将 RecyclerView 定位到最后的一行
                    msgRecyclerView.scrollToPosition(msgList.size());
                    // 清空输入框中的内容
                    inputText.setText("");
                }
                break;
            case R.id.receive:
                String testMsg = "Hello World!";
                if (!"".equals(testMsg)) {
                    Msg msg = new Msg(testMsg, Msg.TYPE_RECEIVED);
                    msgList.add(msg);
                    // 当有新消息是，刷新 ListView 中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    // 将 RecyclerView 定位到最后的一行
                    msgRecyclerView.scrollToPosition(msgList.size());
                }
                break;
        }
    }
}
