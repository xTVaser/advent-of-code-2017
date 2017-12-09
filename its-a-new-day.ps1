$client = New-Object System.Net.WebClient

$dateStr = Read-Host 'What is the date in the Advent Calendar'
[int]$date = [convert]::ToInt32($dateStr, 10)

If ($date -gt 25 -Or $date -lt 1) {
    Write-Host "Invalid Date, 1-25 pls"
    Exit
}

$cookie = Read-Host 'Enter Session Cookie for www.adventofcode.com'
$client.Headers.Add([System.Net.HttpRequestHeader]::Cookie, "session=" + $cookie)

New-Item -ItemType Directory "day-$date" | Out-Null

Invoke-Expression "lein new app part1 --to-dir day-$date/part1"
Invoke-Expression "lein new app part2 --to-dir day-$date/part2"

$client.DownloadFile("http://adventofcode.com/2017/day/$date/input", 'input')

Copy-Item "input" -Destination "day-$date/part1/resources"
Move-Item "input" -Destination "day-$date/part2/resources"