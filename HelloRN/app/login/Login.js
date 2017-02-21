/**
 * Create by lapsen_wang on 2017/2/21/0021
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    View,
    TextInput,
    TouchableOpacity,
    Text,
} from 'react-native';

export default class Login extends Component {
    render() {
        return (
            <View style={styles.container}>
                <TextInput style={styles.textInput}
                           underlineColorAndroid={'transparent'}
                placeholder={'用户名'}/>
                <TextInput style={styles.textInput}
                underlineColorAndroid={'transparent'}
                           ref="ti1"
                           placeholder={'密码'}
                />
                <TouchableOpacity style={styles.button}
                                  onPress={() => {alert(1)}}
                >
                    <Text style={{color:'white'}}>登录</Text>
                </TouchableOpacity>
            </View>
        );
    }
}

var styles = StyleSheet.create({
    container:{
        flex:1,
        justifyContent:'center',
        alignItems:'center',
    },
    button:{
        width:300,
        height:40,
        borderRadius:20,
        backgroundColor:'green',
        alignItems:'center',
        justifyContent:'center',
        margin:10,
    },
    textInput:{
        width:300,
        margin:10,
        borderWidth:1,
        height:40,
        borderRadius:20,
        borderColor:'gray',
        paddingLeft:20,
    },

});