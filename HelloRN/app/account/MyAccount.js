/**
 * Create by lapsen_wang on 2017/2/27/0027
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    ListView,
    StyleSheet,
    View,TouchableHighlight,
    Text,
} from 'react-native';

import item from './ListViewItem';

export default class MyAccount extends Component {
    constructor(props){
        super(props);
        var ds = new ListView.DataSource({rowHasChanged:(r1, r2) => r1 !== r2});     //只更新变化的行
        this.state = {
          dataSource : ds.cloneWithRows(this._getRowData()),
        };

        //bind,必须有
        this._renderRow = this._renderRow.bind(this);
    }

    _getRowData(){
        const data = [];
      for(var i =0; i < 100; i++) {
          data.push("我是列表数据:" + i);
      }
      return data;
    };

    /*渲染行*/
    _renderRow = (rowData: string, sectionID: number, rowID: number) =>{
return(
    <item
    onSelect = {() =>{
        this._pressRow(rowID);
    }}
    rowData = {rowData}
    />
);
    };

    /*点击事件*/
    _pressRow = (rowId) =>{
        alert(rowId);
};

    /*渲染分割线*/

    // _renderSeparator(sectionID: number, rowID: number, adjacentRowHighlighted: bool) {
    //     return (
    //         <View key={`{sectionID}-${rowID}`}
    //               style={{height: 1, backgroundColor: 'black'}}>
    //         </View>
    //     );
    // }

    render() {
        return (
            <ListView
            dataSource={this.state.dataSource}
            renderRow={this._renderRow}
            />
        );
    }
}

// var styles = StyleSheet.create({
//     item_style:{
//         height:50,
//         justifyContent:'center',
//         alignItems:'center',
//     },
// });