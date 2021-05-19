
import ToDo from './ToDo.js';

export default function ToDoList({taskList, handleToggle}) {
  return (<div className="list">
    {taskList.map((task) => {
      return <ToDo task={task} handleToggle={handleToggle} key={task.id}/>
    })}
    </div>
  )
};