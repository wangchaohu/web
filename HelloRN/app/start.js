/**
 * Created by lapsen_wang on 2017/2/13/0013.
 *
 *为了兼容android与ios设置的同意程序入口
 */

import React, {Component} from "react";
import {AppRegistry} from "react-native";

// import StartUp from './hello/StartUp';
// import  Start from './helloworld/HelloWorld';
// import ss from './movielist/MovieList';
// import Start from './state/State';
// import Start from './component/Components';
// import Start from './scene/SimpleNavigationApp';
// import Start from './btn/Buttons';
// import Start from './fetch/FetchDemo';
import Start from './login/Login';
AppRegistry.registerComponent('HelloRN', () => Start);