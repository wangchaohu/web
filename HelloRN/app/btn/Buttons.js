/**
 * Create by lapsen_wang on 2017/2/15/0015
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    View,
    Text,
    TouchableHighlight,
    TouchableOpacity,
    Button,
} from 'react-native';

import Btn from '../component/Components';

export default class Buttons extends Component {
    fetchData = (enabledCallBack) => {
        console.log(3);
      this.timer = setTimeout(() => {
          enabledCallBack();
      }, 3000);

    };

    componentWillUnmount(){

        this.timer && clearTimeout(this.timer);
    }

    render() {
        return (
            <View style={styles.container}>
                <Text>下面是按钮的示例</Text>
                <Btn text="确定" bg="red" click={() => alert('你点击了确定按钮')}/>
                <Btn text="取消" bg="green" click={this.fetchData }/>
            </View>

        );
    }
}

var styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
});