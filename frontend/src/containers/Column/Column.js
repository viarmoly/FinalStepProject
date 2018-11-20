import React from 'react';
import LeadCard from '../Card/LeadCard';
import {Droppable} from "react-beautiful-dnd";
import './_column.scss'

export default class Column extends React.Component {
    render() {
        return (
            <div className="column-container">
                <div className="column-title">
                    {this.props.column.title}
                </div>
                <Droppable droppableId={this.props.column.id}>
                    {provided => (
                        <div className="lead-list"
                             ref={provided.innerRef}
                             {...provided.droppableProps}
                        >
                            {this.props.leads.map((lead, index) => (
                                <LeadCard lead={lead} index={index}/>
                            ))}
                            {provided.placeholder}
                        </div>
                    )}
                </Droppable>
            </div>
        );
    }
}