import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ToDo from './ToDo.js';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
    backgroundColor: theme.palette.background.paper,
  },
}));

export default function ToDoList({taskList, toggleComplete, editTask, deleteTask}) {
  const classes = useStyles();

  return (<List className={classes.root}>
    {taskList.map((task) => {
      return <ToDo task={task} toggleComplete={toggleComplete} editTask={editTask} deleteTask= {deleteTask} key={task.id}/>
    })}
    </List>
  )
};