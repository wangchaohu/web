/**
 * Create by lapsen_wang on 2017/2/28/0028
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    TouchableHighlight,
    TouchableOpacity,

} from 'react-native';

export default class ListViewItem extends Component {

    constructor(props){
        super(props);

    };

    render() {
        //解构
        const {data,onSelect} = this.props;
        return (

            <TouchableOpacity
                style={styles.row}
                onPress = {this.props.onSelect}
            >
                <Text>
                    {this.props.data}
                </Text>
            </TouchableOpacity>
        );
    }
}
var styles = StyleSheet.create({
    row:{
        height:50,
        justifyContent:'center',
        alignItems:'center',
    },
});