local string = require 'string'

local Hamming = {}

function Hamming.compute(a, b)
    local a_length = string.len(a)
    local b_length = string.len(b)

    if a_length ~= b_length then return -1 end

    local hamming_distance = 0

    for index = 1, a_length, 1 do
        local a_dna = string.sub(a, index, index)
        local b_dna = string.sub(b, index, index)
        if a_dna ~= b_dna then
            hamming_distance = hamming_distance + 1
        end
    end

    return hamming_distance
end

return Hamming
