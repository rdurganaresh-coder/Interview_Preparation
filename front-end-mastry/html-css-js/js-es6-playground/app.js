document.getElementById('loadBtn').addEventListener('click', async () => {
  const out = document.getElementById('output');
  try {
    const res = await fetch('http://localhost:8102/api/topics');
    const data = await res.json();
    out.textContent = JSON.stringify(data, null, 2);
  } catch (err) {
    out.textContent = 'Backend offline on :8102 — ' + err.message;
  }
});
