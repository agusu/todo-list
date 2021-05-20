import List from '@material-ui/core/List';
import ToDo from './ToDo.js';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
  toDoList: {
    width: '100%',
    minWidth: '250px',
    backgroundColor: theme.palette.background.paper,
    borderRadius: "5px"
  },
}));

export default function ToDoList({taskList, toggleComplete, editTask, deleteTask}) {
  const classes = useStyles();

  return (<List className={classes.toDoList}>
    {taskList.map((task) => {
      return <ToDo task={task} toggleComplete={toggleComplete} editTask={editTask} deleteTask= {deleteTask} key={task.id}/>
    })}
    </List>
  )
};