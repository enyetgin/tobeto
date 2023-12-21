import { useState } from 'react';
import './App.css';

function TodoApp() {

  const [newTodo, setNewTodo] = useState("")
  const [todos, setTodos] = useState([])

  function handleAddTodo(){

    if(!newTodo){
      alert("Type your new to do")
      return
    }

    const todo = {
      id: Math.floor(Math.random()*1000),
      value: newTodo
    }
    setTodos(oldTodos => [...oldTodos, todo])
    setNewTodo("")a
  }

  function handleDeleteTodo(id){
    const newArray = todos.filter(todo => todo.id !== id)
    setTodos(newArray)
    
  }

  return (
    <div className="App">
      <h1>To-Do List App</h1>

      <input type='text' placeholder='create a new to do' value={newTodo} 
      onChange={todo => setNewTodo(todo.target.value)}/>

      <button onClick={() => handleAddTodo()}>Add</button>

      <ul>
        {todos.map(todo => {
          return(
            <li key={todo.id}>{todo.value} <button onClick={() => handleDeleteTodo(todo.id)}> X </button></li>
          )
        })}
      </ul>

    </div>
  );
}

export default TodoApp;
