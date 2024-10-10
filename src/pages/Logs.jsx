import React, { useState } from 'react'
import axios from 'axios';
import { data } from 'autoprefixer';
export default function Logs() {
  const [logs, setLogs] = useState([]);
  const [query, setQuery] = useState({
    property: '',
    value: ''
  });
  const fetchLogs = async (property, value) => {
    const url = `http://localhost:3000/logs/` + property + '/' + value;
    try {
      const response = await axios.get(url);
      setLogs(response.data);
      console.log(logs);
      console.log(url);
    } catch (error) {
      console.log(error);
    }
  }

  const handleInputChange = (field, value) => {
    setQuery((prevQuery) => ({
      ...prevQuery, [field]: value
    }));
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    if (query.property && query.value) {
      fetchLogs(query.property, query.value)
    }
  }
  return (
    <div className='p-20 grid grid-cols-1'>
      {/* <span className='text-3xl font-bold mb-10'>Query</span> */}
      <form onSubmit={handleSubmit}>
        <div className='grid grid-cols-1 border rounded shadow p-8'>
          <div>
            <label className='block text-sm font-bold text-gray-700 mb-2' htmlFor='property'>
              Select Property
            </label>
            <select
              id='property'
              name='property'
              className='w-full p-4 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline'
              onChange={(e) => handleInputChange('property', e.target.value)}
            >
              <option value="">Select</option>
              <option value="level">Level</option>
              <option value="message">Message</option>
              <option value="resourceId">Resource ID</option>
              <option value="timestamp">Timestamp</option>
              <option value="traceId">Trace ID</option>
              <option value="spanId">Span ID</option>
              <option value="commit">Commit</option>
            </select>
          </div>
          <div>
            <label className='block mb-2 text-sm font-bold text-gray-700 mt-2' htmlFor='value'>
              Enter Value
            </label>
            <input
              type="text"
              id="value"
              name="value"
              placeholder='Value'
              className='w-full p-4 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline mb-4'
              onChange={(e) => { handleInputChange('value', e.target.value) }}
            />
          </div>
          <div>
            <button
              type="submit"
              className='w-full bg-[#e297de] p-4 rounded-md hover:bg-[#854081] hover:text-white font-semibold'>
              Query Logs
            </button>
          </div>
        </div>
      </form>
      <div className="mt-8">
        {logs.length > 0 ? (
          <div className='overflow-x-auto'>
          <table className="min-w-full border-collapse border border-gray-200">
            <thead>
              <tr>
                {/* <th className="border p-2">ID</th> */}
                <th className="border p-2">Level</th>
                <th className="border p-2">Message</th>
                <th className="border p-2">Resource ID</th>
                <th className="border p-2">Timestamp</th>
                <th className="border p-2">Trace ID</th>
                <th className="border p-2">Span ID</th>
                <th className="border p-2">Commit</th>
                <th className="border p-2">Metadata</th>
              </tr>
            </thead>
            <tbody>
              {logs.map((log) => (
                <tr key={log.id}>
                  {/* <td className="border p-2">{log.id}</td> */}
                  <td className="border p-2">{log.level}</td>
                  <td className="border p-2">{log.message}</td>
                  <td className="border p-2">{log.resourceId}</td>
                  <td className="border p-2">{log.timeStamp}</td>
                  <td className="border p-2">{log.traceId}</td>
                  <td className="border p-2">{log.spanId}</td>
                  <td className="border p-2">{log.commit}</td>
                  <td className="border p-2">{log.metadata}</td>
                </tr>
              ))}
            </tbody>
          </table>
          </div>
        ) : (
          <p>No logs found.</p>
        )}
      </div>
    </div>
  )
}
