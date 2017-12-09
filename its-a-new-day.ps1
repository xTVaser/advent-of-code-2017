$client = New-Object System.Net.WebClient

$dateStr = Read-Host 'What is the date in the Advent Calendar'
[int]$date = [convert]::ToInt32($dateStr, 10)

If ($date > 25 -Or $date < 1) {
    Write-Host "Invalid Date, 1-25 pls"
    Exit
}

$client.DownloadFile("http://adventofcode.com/2017/day/1/input", 'test')