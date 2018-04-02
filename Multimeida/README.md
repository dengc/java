# Multimedia

@(IT Studies)

## Digital Data
-------------------------------------
### Analog to Digital
1. Sampling -> Quantization
2. Bit rate = (bits/sec) = Sampling rate (sampling frequency) x Quantization bits per sample = F * Q
3. NYQUIST’S SAMPLING THEOREM
    >Sampling frequency should be at least 2F for a signal whose maximum frequency is F
    <==> 2 cut-off F = F we sampled

if less then 2F, aliasing

###  filter
To avoid aliasing, digital low-pass filter before subsampling

### Scan
1. Progressive - left to right, top to bottom
2. Interlaced - even line, odd lines 

### Subsampling
![Alt text](./Screen Shot 2018-03-31 at 10.40.33 PM.png)

### 题目
- F of stereophonic music = F of 2 mono music
- File size = 长 * 宽 * ppi的平方 * color representation (bits)  (1 byte = 8 bits)
    - n color: log n color rep

## Color  Theory
-------------------------------------
### Frequency
- Red to Purple : f -> low to high
- f = v / Wavelength = 1/T
- different spectrum can be same perceived color C

### Projector
- P(primaries) = 3 light sources, associated with M
- M {m1, m2, m3} = filters, generate channels
- a {a1, a2, a3} = channels
- g = generated spectrum

#### Different Filters
- RGB -> associated with primaries
- XYZ -> CIE


## Information  Theory & Compression
-------------------------------------
### 计算1：
If your vocabulary has N symbols, each symbol represented with log 2 N bits.
<===> each symbol has x bits -> having 2's power of x symbols
- example:
> A(00), B(01), C(10), D(11)

### 计算2：
ith symbol length = l(i) bits
emit M symbols = M = m(i) 从i->N, has been emitted m(i) times
number of bits = l(i)m(i) 从i->N
average symbol length = L = l(i)m(i) / M
average bit rate = L / T
also, 
L = P(i)l(i) 从i->N

### 计算3：
Entropy (H) = 1/4 log2(4) + 1/4 log2(4) + 1/2 log2(2)
- Entropy (H) is highest (equal to log 2 N) if all symbols are equally probable
- Entropy is small (always > 0) when some symbols that are much more likely to appear than other symbols

Efficiency = H / L

### Lossless Compression
ENTROPY ENCODING
- LZW – PATTERN SUBSTITUTION
- HUFFMAN CODING
- ARITHMETIC CODING

### Lossy Compression
Lossy Compression is always a tradeoff between rate (number of bits used) and distortion
<==> R 和 distortion 成反比

- Differential PCM : d(n) = y(n) - y(n-1)
- TRANSFORM CODING

### 题目
- Subband coding gives different resolutions to different bands. 
    - if each different section band needs to be encoded differently, use subband

- Subsampling groups pixels together into a meta-region and encodes a single value for the entire region.
- how subband coding is used in MPEG1 audio: Audio PCM -> filter bank which gives different channel or bands -> each band separately encoded and quantized using different uniform quantization intervals.
- In JPEG – spectral selection (subband), successive approx. (neither, but closer to subband), hierarchical (subsampling)
- CBR: fixed bit rate -> faster (throughput is greater, quality may be compromised depending on your bandwidth.)
- VBR: dynamically change -> small size (Huffman, Lossless mode of JPEG)

## Image Compression
-------------------------------------
Resolution越高，单位面积内pixel越多，pixel密度(ppi) 越大
1080p: 1920×1080 px, HD (high-definition)

### JPEG COMPRESSION ALGORITHMIC
1. 8x8 pixels
2. DCT
3. scalar quantization
4. entropy coder

### JPEG-2000
JPEG-2000 has better compression performances than JPEG, high complexity
- divided into tiles, then quantized
- Each code-block is entropy-coded independently
- encoded “naturally” progressively

### DITHERING
Normally done by dividing the image into k x k blocks. Each block can represent k2 +1 intensity levels.

## Video Compression
-------------------------------------
### Redundancy
Spatial or Temporary
Intraframe: Each frame is encoded as an entity
Interframe: for Temporary - Motion Compensation: between current frame to prediction

### Motion Compensation
If we use lossy encoding, we should use a closed-loop scheme!
Compression of I < compression of P < compression of B
- I‑frames don't require other video frames to decode.
- P‑frames can use data from previous frames to decompress
- B‑frames can use both previous and forward frames for data reference to get the highest amount of data compression.

## Audio Compression
-------------------------------------
### Waveform
statistical distribution 
- w/ DPCM & Entropy Coding

### Perception-Based
Psychoacoustics
- with human auditory system

### Production-Based
Physics Model motivated

### Event Lists
structured audio
- low-bandwidth trans
- music synthesis and creation

## Digital Rights Management
------------------------------------
> copyright protection

watermarking
encryption