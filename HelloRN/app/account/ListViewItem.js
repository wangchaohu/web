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
} from 'react-native';

export default class ListViewItem extends Component {

    constructor(props){
        super(props);
        this.state = {rowData:''}
        const {rowData,_pressRow} = this.props;
    };

    render() {
        return (
            <TouchableHighlight
                onPress = {this.props._pressRow}
            >
            <View style={styles.row}>
                <Text>
                    {this.props.rowData}
                </Text>
            </View>
            </TouchableHighlight>
        );
    }
}

/*点击事件*/
_pressRow = (sectionID:number, rowID:number) =>{
    alert(sectionID + "     " + rowID);
};

var styles = StyleSheet.create({
    row:{
        height:50, backgroundColor:'gray',
    },
});