/**
 * Create by lapsen_wang on 2017/2/14/0014
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    View,
    Text,
    ListView,
} from 'react-native';

export default class Components extends Component {
    constructor(props){
        super(props);
        const ds = new ListView.DataSource({rowHasChanged : (r1, r2) => r1 !== r2});
        this.state = {
            dataSource : ds.cloneWithRows(['John', 'Joel', 'James', 'Jimmy', 'James', 'Jillian', 'Julie', 'Devin'])
        };
    }
    render() {
        return (
            <View style={{flex:1}}>
                <ListView
                dataSource={this.state.dataSource}
                renderRow={(rowData) => <Text>{rowData}</Text>}
                />
            </View>
        );
    }
}