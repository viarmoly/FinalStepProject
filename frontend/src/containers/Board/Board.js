import React, {Component} from 'react';
import {DragDropContext} from 'react-beautiful-dnd';
import data from '../Data';
import Column from '../Column/Column';
import './_board.scss';


class Board extends Component {

    state = data;

    onDragEnd = result => {
        const {destination, source, draggableId} = result;

        if (!destination) {
            return;
        }

        if (
            destination.droppableId === source.droppableId &&
            destination.index === source.index
        ) {
            return;
        }

        const begin = this.state.columns[source.droppableId];
        const end = this.state.columns[destination.droppableId];

        if (begin === end) {
            const newLeadIds = Array.from(begin.leadIds);
            newLeadIds.splice(source.index, 1);
            newLeadIds.splice(destination.index, 0, draggableId);

            const newColumn = {
                ...begin,
                leadIds: newLeadIds,
            };
            const newState = {
                ...this.state,
                columns: {
                    ...this.state.columns,
                    [newColumn.id]: newColumn,
                },
            };
            this.setState(newState);
            return;
        }
            const beginLeadIds = Array.from(begin.leadIds);
        beginLeadIds.splice(source.index, 1);
        const newBegin = {
            ...begin,
            leadIds: beginLeadIds
        };
        const endLeadIds = Array.from(end.leadIds);
        endLeadIds.splice(destination.index, 0, draggableId);
        const newEnd = {
            ...end,
            leadIds: endLeadIds
        };
        const newState = {
            ...this.state,
            columns: {
                ...this.state.columns,
                [newBegin.id]: newBegin,
                [newEnd.id]: newEnd,
            },
        };
        this.setState(newState)
    };

    render() {

        return (
            <div className="board">
                <DragDropContext onDragEnd={this.onDragEnd}>
                    {this.state.columnsort.map(columnId => {
                        const column = this.state.columns[columnId];
                        const leads = column.leadIds.map(leadId => this.state.leads[leadId]);
                        return <Column key={Column.id} column={column} leads={leads}/>;
                    })}
                </DragDropContext>
            </div>
        )
    }
}
export default Board;