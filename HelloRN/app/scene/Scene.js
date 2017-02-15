/**
 * Create by lapsen_wang on 2017/2/14/0014
 * Function:
 * Desc:
 */

import React, {Component} from 'react';
import {
    View,
    Text,
    TouchableHighlight,
} from 'react-native';

export default class Scene extends Component {
    static propTypes = {
        title: React.PropTypes.string.isRequired,
        onForward: React.PropTypes.func.isRequired,
        onBack: React.PropTypes.func.isRequired,
    }
    render() {
        return (
            <View>
                <Text>Current Scene {this.props.title}</Text>
                <TouchableHighlight
                    onPress={this.props.onForward}
                >
                    <Text>点我进入下一场景</Text>
                </TouchableHighlight>

                <TouchableHighlight
                    onPress={this.props.onBack}
                >
                    <Text>点我进入上一场景</Text>
                </TouchableHighlight>
            </View>
        )
    }
}