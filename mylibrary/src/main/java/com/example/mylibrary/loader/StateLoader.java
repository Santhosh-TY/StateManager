package com.example.mylibrary.loader;


import com.example.mylibrary.state.IState;
import ohos.agp.components.Component;

/**
 * 状态加载器，加载各种状态
 */
public interface StateLoader {


    /**
     * 注册一个状态器，如果有重复的状态改变器，则不添加
     *
     * @param changger
     */
    boolean addState(IState changger);

    /**
     * 如果对应的状态加载器
     *
     * @param state 状态
     */
    boolean removeState(String state);
    Component getStateView(String state);
}