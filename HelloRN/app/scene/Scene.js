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
    TouchableHighlight,
} from 'react-native';

export default class Scene extends Component {
    static propTypes = {
        title : PropTypes.string.isRequired,
        onForward: PropTypes.func.isRequired,
        onBack:PropTypes.func.isRequired,
    }
    render() {
        return (
            <View>
                <Text>Current Scene {this.props.title}</Text>
                <TouchableHighlight
                onPress = {this.props.onForward}
                >
                    <Text>点我进入下一场景</Text>
                </TouchableHighlight>

                <ToucableHighlight
                onPress = {this.props.onBack}
                >
                    <Text>点我进入上一场景</Text>
                </ToucableHighlight>
            </View>
        )
    }
}