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
    View,
    TouchableHighlight,
    Text,
} from 'react-native';

import Item from './ListViewItem';

export default class MyAccount extends Component {
    constructor(props){
        super(props);
        var ds = new ListView.DataSource({
            getSectionData:sectionData,
            getRowData:rowData,
            rowHasChanged:(r1,r2) => r1 !== r2,
            sectionHeaderHasChanged:(s1,s2) => s1 !== s2
        });     //只更新变化的行
        this.state = {
          dataSource : ds.cloneWithRowsAndSections({'section1':['1','2','3'],'section2':['row1','row2','row1','row2','row1','row2','row1','row2'],"section3":this._getRowData(), })
        };


    }

    getInitialState = () =>{
        var sectionData = (dataBlob,sectionID) => {
            return dataBlob[sectionID];
        };
        var rowData = (dataBlob,sectionID,rowID) => {
            return dataBlob[sectionID + ':' + rowID];
        };

        return{

        }
    };

    _getRowData = () =>{
        const data = [];
      for(var i =0; i < 10; i++) {
          data.push("我是列表数据:" + i);
      }
      for (var i = 0; i < 20; i++){
          data.push("你是列表：" + i);
      }
        for (var i = 0; i < 30; i++){
            data.push("ta是列表：" + i);
        }
      return data;
    };

    /*渲染行*/
    _renderRow = (rowData: string, sectionID: number, rowID: number) =>{
return(
    <Item
    onSelect = {() =>{
        this._pressRow(rowID, sectionID);
    }
    }
    data = {rowData}
    />
);
    };

    /*点击事件*/
    _pressRow = (rowId,sectionId) =>{
        alert(rowId + "    " + sectionId);
};

    /*渲染分割线*/

    _renderSeparator(sectionID: number, rowID: number, adjacentRowHighlighted: bool) {
        return (
            <View key={`{sectionID}-${rowID}`}
                  style={{height: 1, backgroundColor: 'black'}}>
            </View>
        );
    };

    /*  渲染粘性标题*/
    _renderSectionHeader = (sectionData, sectionID) =>{
        return(
            <Text>
                {sectionData}
            </Text>
        );
    };

    render() {
        return (
            <ListView
            dataSource={this.state.dataSource}
            enableEmptySections={true}
            initialListSize={11}
            renderRow={this._renderRow}
            renderSeparator={this._renderSeparator}
            renderSectionHeader={this._renderSectionHeader}
            />
        );
    }
}