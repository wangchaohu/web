/**
 * Create by lapsen_wang on 2017/2/14/0014
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    View,
    Text,
    TouchableOpacity,
} from 'react-native';

export default class Components extends Component {
    constructor(props) {
        super(props);
        this.state = {disabled: false};
    }

    //把自定义方法作为属性定义
    customButtonHandler = () => {
        const {click} = this.props;
        console.log(1);
        this.disopen();
        click(this.enopen);
    };

    enopen = () =>{
        // alert('正在获取数据.....');
      this.setState({
          disabled : false,
      });
        console.log(4);
      alert("你可以点击按钮了");
    };

    disopen = () =>{
      this.setState({
          disabled:true,
      });
    };

    render() {
        //解构
        const {text, bg} = this.props;
        return (
            <View style={{flex:1 }}>
                <TouchableOpacity
                    disabled={this.state.disabled}
                    style={[styles.button, this.state.disabled && styles.buttonT,{backgroundColor:bg}]}
                    onPress={this.customButtonHandler}
                >
                    <Text style={styles.buttonText}>{this.props.text}</Text>
                </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    button: {
        height: 48,
        width: 300,
        borderRadius: 24,
        backgroundColor: 'blue',
        justifyContent: 'center',
        margin: 20,
    },
    buttonText: {
        textAlign: 'center',
        color: 'white',
    },
    buttonT:{
      backgroundColor:'gray',
    },
});