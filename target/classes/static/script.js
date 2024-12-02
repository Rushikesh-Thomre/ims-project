// Assuming you have some predefined stock data (can be fetched from Spring Boot)
let stockData = [
    { id: 1, name: "Item A", quantity: 100 },
    { id: 2, name: "Item B", quantity: 50 },
    { id: 3, name: "Item C", quantity: 200 }
];

// Function to load items into the dropdown
function loadItems() {
    const itemSelect = document.getElementById('item');
    itemSelect.innerHTML = ''; // Clear previous options

    stockData.forEach(item => {
        const option = document.createElement('option');
        option.value = item.id;
        option.textContent = item.name;
        itemSelect.appendChild(option);
    });
}

// Function to update the stock table
function updateStockTable() {
    const stockTableBody = document.getElementById('stockTable').getElementsByTagName('tbody')[0];
    stockTableBody.innerHTML = ''; // Clear previous rows

    stockData.forEach(item => {
        const row = stockTableBody.insertRow();
        const cellName = row.insertCell(0);
        const cellQuantity = row.insertCell(1);

        cellName.textContent = item.name;
        cellQuantity.textContent = item.quantity;
    });
}

// Event listener for the "Submit" button
document.getElementById('submitStockAction').addEventListener('click', function() {
    const itemId = document.getElementById('item').value;
    const quantity = parseInt(document.getElementById('quantity').value);
    const action = document.getElementById('action').value;

    if (!itemId || isNaN(quantity) || quantity <= 0) {
        alert('Please provide valid input.');
        return;
    }

    const item = stockData.find(item => item.id == itemId);

    if (action === 'in') {
        item.quantity += quantity;
    } else if (action === 'out') {
        if (item.quantity >= quantity) {
            item.quantity -= quantity;
        } else {
            alert('Not enough stock available.');
            return;
        }
    }

    updateStockTable();  // Update the stock table to reflect changes
});

// Initialize the page
loadItems();
updateStockTable();
