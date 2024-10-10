import React from "react";
import Landing from "./pages/Landing";
import './App.css'
import Ingestor from "./pages/Ingestor";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Logs from "./pages/Logs";
export default function App() {
  return(
    <>
      <BrowserRouter>
        <Routes>
          <Route index element = {<Landing/>}></Route>
          <Route path = "/" element = {<Landing/>}></Route>
          <Route path = "/ingest" element = {<Ingestor/>}></Route>
          <Route path = "/logs" element = {<Logs/>}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}