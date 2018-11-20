const data = {
    leads: {
        "lead-1": {id: 'lead-1', firstName: 'Олег', lastName: 'Третьяков', surName: 'Константинович', tel:'+38 064 343 43 34'},
        "lead-2": {id: 'lead-2', firstName: 'Семен', lastName: 'Тихонов', surName: 'Петрович', tel:'+38 063 445 55 56'},
        "lead-3": {id: 'lead-3', firstName: 'Екатерина', lastName: 'Кут', surName: 'Дмитриевна', tel:'+38 064 343 43 34'},
        "lead-4": {id: 'lead-4', firstName: 'Олександра', lastName: 'Зайцева', surName: 'Ивановна', tel:'+38 064 343 43 34'},
        "lead-5": {id: 'lead-5', firstName: 'Ольга', lastName: 'Васильева', surName: 'Данилова', tel:'+38 064 343 43 34'},
        "lead-6": {id: 'lead-6', firstName: 'Анатолий', lastName: 'Коваленко', surName: 'Яковлевич', tel:'+38 064 343 43 34'},
        "lead-7": {id: 'lead-7', firstName: 'Владислав', lastName: 'Емельянов', surName: 'Исакович', tel:'+38 064 343 43 34'},
        "lead-8": {id: 'lead-8', firstName: 'Виктор', lastName: 'Ярмолицкий', surName: 'Сергеевич', tel:'+38 064 343 43 34'},
        "lead-9": {id: 'lead-9', firstName: 'Веталий', lastName: 'Пинчук', surName: 'Константинович', tel:'+38 064 343 43 34'},
        "lead-10": {id: 'lead-10', firstName: 'Наталия', lastName: 'Бабич', surName: 'Борисович', tel:'+38 064 343 43 34'},
        "lead-11": {id: 'lead-11', firstName: 'Оксана', lastName: 'Житина', surName: 'Валериивна', tel:'+38 064 343 43 34'},
        "lead-12": {id: 'lead-12', firstName: 'Денис', lastName: 'Третьяков', surName: 'Константинович', tel:'+38 064 343 43 34'},
    },

    columns: {
        'column-1': {
            id: 'column-1',
            title: "Валидация",
            leadIds: ['lead-1','lead-2','lead-3','lead-4','lead-5','lead-6']
        },
        'column-2': {
            id: 'column-2',
            title: 'Звонки',
            leadIds: ['lead-7','lead-10','lead-11'],
        },
        'column-3': {
            id: 'column-3',
            title: 'Встречи',
            leadIds: ['lead-8','lead-12'],
        },
        'column-4': {
            id: 'column-4',
            title: 'Подписание',
            leadIds: ['lead-9'],
        }
    },

    columnsort: ['column-1', 'column-2', 'column-3', "column-4"]
}
export default data;