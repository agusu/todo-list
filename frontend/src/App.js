import './App.css';
import { Container, TextField, FormGroup, IconButton, Paper} from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import { makeStyles, ThemeProvider } from '@material-ui/core/styles';
import theme from './themeConfig.js'
import ToDoList from './components/ToDoList.js';
import AssignmentOutlinedIcon from '@material-ui/icons/AssignmentOutlined';
import {useEffect, useState} from 'react';
import axios from 'axios';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(2),
      justifyContent: "center"
    },
  },
}));

function App() {
  const [taskList, setTaskList] = useState([]);
  const [ userInput, setUserInput ] = useState('');
  
  const classes = useStyles();
  const addTask = () => {
    axios.post('/api/task', {name: userInput})
    .then((res) => { 
      setTaskList([...taskList, res.data]);
    })
    .catch(() => {console.log("Error adding task.")})
  }

  useEffect(() => {getTasks();},[])

  const getTasks = () => {
    axios.get('/api/task/').then(res => {setTaskList(res.data);})
    .catch(() => {console.log("Error fetching tasks.")})
  }

  const toggleComplete = (id) => {
    setTaskList(taskList.map(task => {
      return task.id === id ? { ...task, complete: !task.complete } : { ...task};
    }));
    axios.patch('/api/task/' + id).catch(() => {console.log("Error updating task completion")})
  }

  const editTask = (id, name) => {
    axios.put('/api/task/', {id, name})
    .then(() => {setTaskList(taskList.map(
      task => {
        return task.id === id ? { ...task, name } : { ...task};}
      ));
    })
    .catch((e) => {console.log(e, "Error updating task name")})
  }

  const deleteTask = (id) => {
    axios.delete('/api/task/' + id).then(() => {
      setTaskList(taskList.filter(task => task.id !== id));
    }).catch(() => {console.log("Error deleting task")});
  }

  const handleAddTask = (e) => {
    e.preventDefault();
    addTask();
    setUserInput("");
  }

  const handleChange = (e) => {
    setUserInput(e.currentTarget.value)
  }

  return (
    <ThemeProvider theme={theme}>
    <div className="App">
      <header>
        <h1><AssignmentOutlinedIcon style={{fontSize: '20px'}}/> My To-Do List</h1>
      </header>
      <Container maxWidth="sm" spacing={2}>
        <form className={classes.root} noValidate onSubmit={handleAddTask}>
          <Paper>
            <FormGroup >
            <TextField id="task" label="New Task" variant="filled" placeholder="Enter task name" 
              value={userInput} onChange={handleChange}
              InputProps={{endAdornment: 
                <IconButton color="primary" type="submit">
                  <AddIcon />
                </IconButton>}}/>
            </FormGroup >
          </Paper>
        </form>
        <ToDoList taskList={taskList} toggleComplete={toggleComplete} 
          editTask={editTask} deleteTask={deleteTask}/>
      </Container>
      <footer>Developed by <a href="https://github.com/agusu" rel="noreferrer" target="_blank">agusu</a></footer>
    </div>
    </ThemeProvider>
  );

}


export default App;
