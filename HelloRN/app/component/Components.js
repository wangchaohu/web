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
        this.state = {disable: false};
    }

    //把自定义方法作为属性定义
    customButtonHandler = () => {
        const {click} = this.props;
        click();
    };

    enabled = () =>{
      this.setState({
          disable : true,
      });
    };

    disabled = () =>{
      this.setState({
          disable:false,
      });
    };

    render() {
        //解构
        const {text, bg} = this.props;
        return (
            <View style={{flex:1 }}>
                <TouchableOpacity
                    style={[styles.button, this.state.disable && styles.buttonT,{backgroundColor:bg},]}
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
      color:'gray',
    },
});