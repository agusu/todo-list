import './App.css';
import { Container, Button, TextField, FormGroup, Fab} from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import { makeStyles } from '@material-ui/core/styles';
import ToDoList from './components/ToDoList.js';
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
    .then(() => { 
      setTaskList([...taskList, {
        id: taskList.length + 1,
        name: userInput,
        complete: false}
      ]);
    })
    .catch(() => {console.log("Error adding task.")})
  }

  useEffect(() => {
    getTasks();
  },[])

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
    setTaskList(taskList.map(task => {
      return task.id === id ? { ...task, name } : { ...task};
    }));
    axios.put('/api/task/', {id, name}).catch((e)=> {console.log(e, "Error updating task name")})
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
    <div className="App">
      <header>
        <h1>My To-Do List.</h1>
      </header>
      <Container maxWidth="sm">
        <form className={classes.root} noValidate onSubmit={handleAddTask}>
        <FormGroup row >
          <TextField id="task" label="New Task" placeholder="Enter task name" value={userInput} onChange={handleChange}/>
          <Fab color="primary" size="medium" type="submit" aria-label="add">
            <AddIcon />
          </Fab>
          </FormGroup >
          </form>
          <ToDoList taskList={taskList} toggleComplete={toggleComplete} editTask={editTask}/>
      </Container>
    </div>
  );

}

export default App;
