package com.example.myapplication;


import com.example.myapplication.state.ExceptionState;
import com.example.myapplication.state.LoadingState;
import com.example.mylibrary.StateLayout;
import com.example.mylibrary.manager.StateEventListener;
import com.example.mylibrary.state.CoreState;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import org.jetbrains.annotations.Nullable;

/**
 * 使用StateLayout来支持局部支持展示各种状态的能力
 */

public class StateLayoutActivity extends Ability {

    @Override
    protected void onStart(@Nullable Intent savedInstanceState) {
        super.onStart(savedInstanceState);
        setUIContent(ResourceTable.Layout_activity_statelayout_demo);


        final StateLayout stateLayout = (StateLayout) findComponentById(ResourceTable.Id_statelayout);

        stateLayout.showState(LoadingState.STATE);
        EventHandler eventhandler = new EventHandler(EventRunner.getMainEventRunner());
        eventhandler.postTask(() -> stateLayout.showState(ExceptionState.STATE), 3000);

        stateLayout.setStateEventListener((state, view) -> stateLayout.showState(CoreState.STATE));

        Button refresh = (Button) findComponentById(ResourceTable.Id_refresh);
        refresh.setClickedListener(v -> stateLayout.showState(LoadingState.STATE));
    }
}