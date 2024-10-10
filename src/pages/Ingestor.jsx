import React, { useState } from 'react';
import axios from 'axios';
import ingest from '../assets/images/ingest.jpg';

export default function Ingestor() {
  const [formData, setFormData] = useState({
    id: '',
    level: '',
    message: '',
    resourceId: '',
    timestamp: '', 
    traceId: '',
    spanId: '',
    commit: '',
    metadata: ''
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(formData);
    try {
      await axios.post('http://localhost:3000/logs', formData);
      setFormData({
        id: '', 
        level: '',
        message: '',
        resourceId: '',
        timestamp: '',
        traceId: '',
        spanId: '',
        commit: '',
        metadata: ''
      });
      console.log('Ingested');
    } catch (error) {
      console.log('Error Ingesting Log :', error);
    }
  };

  return (
    <div className='p-12 grid grid-cols-2 max-md:grid-cols-1 max-md:space-y-5 max-sm:grid-cols-1 max-lg:grid-cols-1'>
      {/* Form */}
      <div className='flex flex-col justify-center'>
        <form className='' onSubmit={handleSubmit}>
          <span className='text-2xl font-semibold'>Ingest New Log</span>
          <div className='' id='form'>
            {/* Level, Message, Resource ID, Timestamp, Trace ID, Span ID, Commit, Metadata */}
            {Object.keys(formData).map((key) => (
              <div key={key}>
                <label className='block mb-1 font-bold text-gray-700' htmlFor={key}>{key}</label>
                <input
                  className='w-full p-1 leading-tight text-gray-700 border rounded focus:outline-none focus:shadow-outline'
                  id={key}
                  type='text'
                  name={key}
                  value={formData[key]}
                  onChange={handleInputChange}
                />
              </div>
            ))}
          </div>
          <button
            type='submit'
            className='bg-[#e297de] p-2 mt-2 w-full rounded-md hover:bg-[#854081] hover:text-white font-semibold'
          >
            Ingest
          </button>
        </form>
      </div>
      {/* Image */}
      <div><img src={ingest} className='animate-up-down max-md:mt-16 max-sm:mt--16' alt='Ingest' /></div>
    </div>
  );
}
