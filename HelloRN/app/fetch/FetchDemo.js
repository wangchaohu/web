/**
 * Create by lapsen_wang on 2017/2/16/0016
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    View,
    Text,
} from 'react-native';

import Button from '../component/Components';
export default class FetchDemo extends Component {
    constructor(props){
        super(props);
        this.state = {title:''};
    }

    fetchData = (callBack) => {
        fetch('http://bbs.reactnative.cn/api/category/3')
            .then((response) => response.json())
            .then((jsonData) => {
            this.setState({
               title: jsonData.topics[0].title,
            });
            })
            .catch((error) => {
                console.warn(error);
            });
        callBack();
    };

    render() {
        return (
            <View>
                <Button text="确定" bg="green" click={this.fetchData}
                />
                <Text>{this.state.title}</Text>
            </View>
        );
    }
}