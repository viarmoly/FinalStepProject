import React from 'react';
import {Link} from "react-router-dom";
import {Draggable} from 'react-beautiful-dnd';
import './_leadCard.scss'

export default class LeadCard extends React.Component {
    render() {
        return (
            <Draggable draggableId={this.props.lead.id} index={this.props.index}>
                {provided => (
                    <Link to={`/login`}>
                    <div className="card"
                         {...provided.draggableProps}
                         {...provided.dragHandleProps}
                         ref={provided.innerRef}
                    >

                            <div className="full-lead-name">
                                {this.props.lead.lastName}&nbsp;{this.props.lead.firstName}&nbsp;{this.props.lead.surName}
                            </div>
                            {this.props.lead.tel}
                            <br/>
                            Кристина
                    </div>
                    </Link>
                )}
            </Draggable>
        );
    }
}