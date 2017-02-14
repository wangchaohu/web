/**
 * Create by lapsen_wang on 2017/2/14/0014
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    Navigator,
    Text,
    View,
} from 'react-native';

import Scene from './Scene';
class SimpleNavigationApp extends Component {
    render() {
        return (
            <Navigator
            initialRoute={{title : 'My Initial Scene', index : 0}}
            renderScene={(route, navigator) =>
            <Scene
            title={route.title}
            onForward={() =>{
                const nextIndex = route.index + 1;
                navigator.push({
                    title : 'Scene ' + nextIndex,
                    index : nextIndex,
                });
                }}
                onBack={() => {
                    if (route.index > 0){
                        navigator.pop();
                    }
                }}
            />
}/>
        )
    }
}