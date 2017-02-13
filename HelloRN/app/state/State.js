/**
 * Create by lapsen_wang on 2017/2/13/0013
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    Text,
    View,
} from 'react-native';

class Greeting extends Component {
    constructor(props){
        super(props);
        this.state = {showText:true};

        //每1000毫秒对state做一次取反操作
        setInterval(() => {
           this.setState({showText: !this.state.showText});
        },1000);
    }
    render() {
        let isShow = this.state.showText ? this.props.text : " ";
        return (
            <Text>{isShow}</Text>
        );
    }
}

export default class State extends Component{
    render(){
        return(

            <View style={{alignItems:'center'}}>
                <Greeting text='I love to blink' />
                <Greeting text='Yes blinking is so great' />
                <Greeting text='Why did they ever take this out of HTML' />
                <Greeting text='Look at me look at me look at me' />
            </View>
        );
    }
}